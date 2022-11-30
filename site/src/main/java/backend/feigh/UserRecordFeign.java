package backend.feigh;

import backend.dto.RecordDto;
import backend.dto.UserRecordDto;
import backend.entity.UserRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "UserRecordFeign", url = "http://localhost:80")
public interface UserRecordFeign {

    @PostMapping("/users/records/{user_id}/{company}/{title}/record")
    UserRecord addUserRecord(@PathVariable Integer user_id, @PathVariable String company, @PathVariable String title,
                             @RequestBody RecordDto record);

    @GetMapping("/users/records/record/{title}")
    UserRecordDto getUserRecordByTitle(@PathVariable String title);

    @GetMapping("/users/records/record/{company}/records")
    List<UserRecordDto> getRecordsByCompanyName(@PathVariable String company);

    @GetMapping("/users/records/record")
    List<UserRecordDto> getAllUserRecords();

    @PutMapping("/users/records/item/{author}/{title}")
    void updateRecord(@PathVariable String author, @PathVariable String title,
                                     @RequestBody RecordDto dto);

    @DeleteMapping("/users/records/record/{title}")
    void deleteRecord(@PathVariable String title);

}
