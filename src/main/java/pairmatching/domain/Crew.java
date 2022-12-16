package pairmatching.domain;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pairmatching.constant.ErrorConstant.ERROR_FILE_READ;
import static pairmatching.constant.MessageConstant.BACKEND_CREW_INFO;
import static pairmatching.constant.MessageConstant.FRONTEND_CREW_INFO;

public class Crew {
    private Course course;
    private String name;

    private static Map<Course, List<String>> crewNames;

    public Crew() {
        crewNames = new HashMap<>();
        init();
    }
    private void init() {
        Course.getList().stream()
                .forEach(course -> crewNames.put(course, new ArrayList<>()));
        readCrew();
    }

    private void readCrew() {
        try {
            readBackend();
            readFrontEnd();
        } catch (IOException e) {
            throw new IllegalArgumentException(ERROR_FILE_READ);
        }
    }

    private static void readBackend() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(BACKEND_CREW_INFO)
        );
        String crewName;
        while ((crewName = reader.readLine()) != null) {
            crewNames.get(Course.BACKEND).add(crewName);
        }
        reader.close();
    }

    private static void readFrontEnd() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(FRONTEND_CREW_INFO)
        );
        String crewName;
        while ((crewName = reader.readLine()) != null) {
            crewNames.get(Course.FRONTEND).add(crewName);
        }
        reader.close();
    }

    public List<String> getCrew(Course course) {
        return crewNames.get(course);
    }
}
