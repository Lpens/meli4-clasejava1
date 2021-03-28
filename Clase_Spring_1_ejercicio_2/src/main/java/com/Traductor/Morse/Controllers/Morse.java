package com.Traductor.Morse.Controllers;

import com.Traductor.Morse.Entity.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Morse {
    @GetMapping("/decodemorse")
    public String decodeMorse(@RequestParam(value="message") String message)
    {
        Message decodesMessage = new Message(message);
        return decodesMessage.decodeMessage();
    }

}
