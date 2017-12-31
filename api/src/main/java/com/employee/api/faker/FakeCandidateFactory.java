package com.employee.api.faker;

import com.employee.api.models.Candidate;
import com.employee.api.repositories.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class FakeCandidateFactory {

    @Autowired
    CandidateRepository candidateRepository;


    public void candidateGenerator() {
        for (int i = 0; i < 100 ; i++) {
            Candidate candidate = Candidate.builder()
                    .firstName(generateName())
                    .lastName(generateName())
                    .email(generateName()+"@gmail.com")
                    .desiredPosition(generatePosition())
                    .skillLevel(2)
                    .city(generateCity())
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .remote(true)
                    .build();

            candidateRepository.save(candidate);
        }
    }

    private String generateName() {
        List<String> names = Arrays.asList("Adam", "Bartek", "Tomasz", "Aaberg", "Aalst",
                "Aara", "Aaren", "Aarika", "Aaron", "Aaronson", "Ab", "Aba", "Abad",
                "Abagael", "Abagail", "Abana", "Abate", "Abba");
        return generateRandomItem(names);
    }

    private String generatePosition() {
        List<String> positions = Arrays.asList("Developer", "IT developer", "Java Developer", "Junior Java Developer");
        return generateRandomItem(positions);
    }

    private String generateCity() {
        List<String> city = Arrays.asList("Warszawa", "Sopot", "Lublin", "Jędrzejów");
        return generateRandomItem(city);
    }

    private String generateRandomItem(List<String> itemsList) {
        Random random = new Random();
        return itemsList.get(random.nextInt(itemsList.size() - 1));
    }


}
