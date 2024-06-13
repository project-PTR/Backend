package PTR.PTR.controller;

import PTR.PTR.model.*;
import PTR.PTR.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureController {
    LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }
    // 강의 생성
    @PostMapping("createLecture")
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture){
        return new ResponseEntity<>(lectureService.createLecture(lecture), HttpStatus.OK);
    }
    // 강사의 강의 조회
    @PostMapping("findTeacherLecture")
    public ResponseEntity<List<Lecture>> findTeacherLecture(@RequestBody Teacher teacher){
        return new ResponseEntity<>(lectureService.findTeacherLecture(teacher), HttpStatus.OK);
    }
    // 강의 검색
    @PostMapping("searchLecture")
    public ResponseEntity<List<Lecture>> searchLecture(@RequestBody String search){
        return new ResponseEntity<>(lectureService.searchLecture(search), HttpStatus.OK);
    }
    // 가격으로 강의 조회
    @PostMapping("findPriceLecture")
    public ResponseEntity<List<Lecture>> findPriceLecture(@RequestBody List<Integer> price){
        int minPrice = price.get(0);
        int maxPrice = price.get(1);
        return new ResponseEntity<>(lectureService.findPriceLecture(minPrice, maxPrice), HttpStatus.OK);
    }
    // 강의 카테고리 수정 및 저장
    @PostMapping("saveLectureCategory")
    public ResponseEntity<String> saveLectureCategory(@RequestBody List<LectureCategory> lectureCategories){
        return new ResponseEntity<>(lectureService.saveLectureCategory(lectureCategories), HttpStatus.OK);
    }
    // 강의 카테고리 삭제
    @PostMapping("deleteLecturerCategory")
    public ResponseEntity<String> deleteLecturerCategory(@RequestBody Lecture lecture){
        return new ResponseEntity<>(lectureService.deleteLecturerCategory(lecture), HttpStatus.OK);
    }
    // 강의의 카테고리 조회
    @PostMapping("findLectureCategory")
    public ResponseEntity<List<LectureCategory>> findLectureCategory(@RequestBody Lecture lecture){
        return new ResponseEntity<>(lectureService.findLectureCategory(lecture), HttpStatus.OK);
    }
    // 카테고리로 강의 찾기
    @PostMapping("findLectureByCategory")
    public ResponseEntity<List<Lecture>> findLectureByCategory(@RequestBody Category category){
        return new ResponseEntity<>(lectureService.findLectureByCategory(category), HttpStatus.OK);
    }
}
