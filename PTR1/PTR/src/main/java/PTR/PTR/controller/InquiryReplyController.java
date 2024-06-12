package PTR.PTR.controller;

import PTR.PTR.model.Inquiry;
import PTR.PTR.model.InquiryReply;
import PTR.PTR.service.InquiryReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InquiryReplyController {
    InquiryReplyService inquiryReplyService;

    public InquiryReplyController(InquiryReplyService inquiryReplyService) {
        this.inquiryReplyService = inquiryReplyService;
    }

    @PostMapping("replyInquiry")
    public ResponseEntity<InquiryReply> replyInquiry(@RequestBody InquiryReply inquiryReply){
        return new ResponseEntity<>(inquiryReplyService.replyInquiry(inquiryReply), HttpStatus.OK);
    }

    @PostMapping("findInquiryReply")
    public ResponseEntity<List<InquiryReply>> findInquiryReply(@RequestBody Inquiry inquiry){
        return new ResponseEntity<>(inquiryReplyService.findInquiryReply(inquiry),HttpStatus.OK);
    }
}
