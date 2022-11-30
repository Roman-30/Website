package backend.controller;

import backend.dto.RecordDto;
import backend.dto.UserRecordDto;
import backend.entity.UserRecord;
import backend.feigh.UserRecordFeign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRecordController {
    private final UserRecordFeign userRecordFeign;

    public UserRecordController(UserRecordFeign userRecordFeign) {
        this.userRecordFeign = userRecordFeign;
    }

    @GetMapping("/user/records/title/{title}")
    public UserRecordDto getUserRecordByTitle(@PathVariable String title) {
        return userRecordFeign.getUserRecordByTitle(title);
    }

    @GetMapping("/user/records/company/{company_name}")
    public List<UserRecordDto> getRecordsByCompany(@PathVariable String company_name) {
        return userRecordFeign.getRecordsByCompanyName(company_name);
    }

    @GetMapping("/user/records")
    public List<UserRecordDto> getAllRecords() {
        return userRecordFeign.getAllUserRecords();
    }

    @PostMapping("/user/records/new/{user_id}")
    public ResponseEntity<UserRecord> addUserRecord(@PathVariable Integer user_id, @RequestBody UserRecordDto dto) {
        return new ResponseEntity<>(userRecordFeign.addUserRecord(user_id, dto.getCompany_name(), dto.getRecord_title(),
                dto.getRecord()), HttpStatus.CREATED);
    }

    @PutMapping("/user/record/update/{author}/{title}")
    public void updateUserRecord(@PathVariable String author, @PathVariable String title,
                                 @RequestBody RecordDto dto) {
        userRecordFeign.updateRecord(author, title, dto);
    }

    @DeleteMapping("/user/record/delete/{title}")
    public void updateUserRecord(@PathVariable String title) {
        userRecordFeign.deleteRecord(title);
    }
}
