package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {


        @Autowired
        ResultRepository resultRepository;
//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Tom", "US"),
//                    new Student(2, "Harry", "Canada"),
//                    new Student(3, "Nick", "UK")
//            )
//    );

        // Mappings - URL endpoints
        // Get the list of all student
        @GetMapping("/listResult")
        public List<Result> getAllResult() {
            return resultRepository.findAll();
        }

        // Get the student information
        @GetMapping("/result/{id}")
        public Result getResult(@PathVariable Integer id) {
            return resultRepository.findById(id).get();
        }

        // Delete the student
        @DeleteMapping("/result/{id}")
        public List<Result> deleteResult(@PathVariable Integer id) {
            resultRepository.delete(resultRepository.findById(id).get());
            return resultRepository.findAll();
        }

        // Add new student
        @PostMapping("/result")
        public List<Result> addStudent(@RequestBody Result Result) {
            resultRepository.save(Result);
            return resultRepository.findAll();
        }

        // Update the student information
        @PutMapping("/result/{id}")
        public List<Result> updateResult(@RequestBody Result result, @PathVariable Integer id) {
            Result resultObj = resultRepository.findById(id).get();
            resultObj.setName(result.getName());
            resultObj.setPercent(result.getPercent());
            resultRepository.save(resultObj);
            return resultRepository.findAll();
        }

    }


