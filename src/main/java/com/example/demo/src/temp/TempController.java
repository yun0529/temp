package com.example.demo.src.temp;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.item.model.GetItemRes;
import com.example.demo.src.temp.model.TempRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;

@RestController
@RequestMapping("")
public class TempController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Autowired
    private final TempService tempService;

    public TempController(TempService tempService) {
        this.tempService = tempService;
    }

    /**
     * [POST] /temp
     *  상품조회 API
     */
    //Query String
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED, isolation = READ_COMMITTED , rollbackFor = Exception.class)
    @PostMapping("/temp") // (GET) 127.0.0.1:9000/item/total
    public BaseResponse<String> postTemp(@RequestBody TempRequest tempRequest) {
        try{
            tempService.postTemp(tempRequest.getTemp());
            return new BaseResponse<>("입력 성공");
        } catch(BaseException exception){
            System.out.println(exception);
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}
