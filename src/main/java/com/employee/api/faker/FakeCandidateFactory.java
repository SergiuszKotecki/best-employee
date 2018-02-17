package com.employee.api.faker;

import com.employee.api.model.Candidate;
import com.employee.api.model.CandidateSkill;
import com.employee.api.model.Location;
import com.employee.api.model.enums.RoleEnum;
import com.employee.api.model.enums.SkillLevelEnum;
import com.employee.api.repository.CandidateRepository;
import com.employee.api.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Component
public class FakeCandidateFactory {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired

    private RoleService roleService;

    private static int c =0;


    public void candidateGenerator() {
                for (int i = 0; i < 100; i++) {
            Candidate candidate = createCandidate();
            candidate.setEmail(candidate.getFirstName()+ i + "@fakeGmail.com");
            candidate.setAuthorities(Collections.singletonList(roleService.findByAuthority(RoleEnum.CANDIDATE)));
            try {
                candidateRepository.save(candidate);
            } catch (PersistenceException e) {
                log.info(e.toString());
            }
        }
    }

    private Candidate createCandidate() {
        LocalDateTime timeNow = LocalDateTime.now();
        Candidate candidate = Candidate.builder()
                .firstName(getNameFromList()+c)
                .lastName(getNameFromList()+c)
                .desiredPosition(getPositionFromList())
                .devLevel(SkillLevelEnum.REGULAR)
                .location(getCityFromList())
                .createdAt(timeNow)
                .updatedAt(timeNow)
                .remote(true)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .password("12345"+c)
                .skills(generateSkills())
                .build();

        candidate.setUsername(candidate.getFirstName() + candidate.getLastName());
        return candidate;
    }

    private Set<CandidateSkill> generateSkills() {
        Set<CandidateSkill> skillsList = new HashSet<>();
        List<String> skillNames = Arrays.asList("Java", "js", "ROR", "TypeScript", "Docker", "K8s", "css3", "html5");
        List<Integer> skillLevel = Arrays.asList(1, 2, 3);
        for (int i = 0; i < chooseRandomItemFromList(skillLevel); i++) {
            skillsList.add(new CandidateSkill(chooseRandomStringFromList(skillNames), chooseRandomItemFromList(skillLevel)));
        }

        return skillsList;
    }

    private String getNameFromList() {
        c++; //:-)
        List<String> names = Arrays.asList("Adam", "Bartek", "Tomasz", "Aaberg", "Aalst",
                "Aara", "Aaren", "Aarika", "Aaron", "Aaronson", "Ab", "Aba", "Abad",
                "Abagael", "Abagail", "Abana", "Abate", "Abba");
        return chooseRandomStringFromList(names);
    }

    private String getPositionFromList() {
        List<String> positions = Arrays.asList("Developer", "IT developer", "Java Developer", "Junior Java Developer");
        return chooseRandomStringFromList(positions);
    }

    private Location getCityFromList() {
        List<String> city = Arrays.asList("Warszawa", "Sopot", "Lublin", "Jędrzejów", "Częstochowa", "Gdańsk");
        return new Location("Poland", chooseRandomStringFromList(city), "Pomorze", "00-000");
    }


    private String chooseRandomStringFromList(List<String> itemsList) {
        Random random = new Random();
        return itemsList.get(random.nextInt(itemsList.size()));
    }

    private Integer chooseRandomItemFromList(List<Integer> itemsList) {
        Random random = new Random();
        return itemsList.get(random.nextInt(itemsList.size()));
    }


}
