package com.employee.api.faker;

import com.employee.api.models.Candidate;
import com.employee.api.models.CandidateSkills;
import com.employee.api.repositories.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class FakeCandidateFactory {

    @Autowired
    CandidateRepository candidateRepository;


    public void candidateGenerator() {
        for (int i = 0; i < 100; i++) {
            Candidate candidate = createCandidate();
            candidateRepository.save(candidate);
        }
    }

    private Candidate createCandidate() {
        return Candidate.builder()
                .firstName(getNameFromList())
                .lastName(getNameFromList())
                .email(getNameFromList() + "@gmail.com")
                .desiredPosition(getPositionFromList())
                .skillLevel(2)
                .city(getCityFromList())
                .createdAt(new Date())
                .updatedAt(new Date())
                .remote(true)
                .skills(generateSkills())
                .build();
    }

    private List<CandidateSkills> generateSkills() {
        List<CandidateSkills> skillsList = new ArrayList<>();
        skillsList.add(new CandidateSkills("Java", 1));
        return skillsList;
    }

    private String getNameFromList() {
        List<String> names = Arrays.asList("Adam", "Bartek", "Tomasz", "Aaberg", "Aalst",
                "Aara", "Aaren", "Aarika", "Aaron", "Aaronson", "Ab", "Aba", "Abad",
                "Abagael", "Abagail", "Abana", "Abate", "Abba");
        return generateRandomItemFromList(names);
    }

    private String getPositionFromList() {
        List<String> positions = Arrays.asList("Developer", "IT developer", "Java Developer", "Junior Java Developer");
        return generateRandomItemFromList(positions);
    }

    private String getCityFromList() {
        List<String> city = Arrays.asList("Warszawa", "Sopot", "Lublin", "Jędrzejów");
        return generateRandomItemFromList(city);
    }

    private String generateRandomItemFromList(List<String> itemsList) {
        Random random = new Random();
        return itemsList.get(random.nextInt(itemsList.size() - 1));
    }


}
