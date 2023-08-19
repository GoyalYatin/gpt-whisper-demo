package com.example.gptwhisperdemo.gptWhisperClient;

import com.example.gptwhisperdemo.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = GptWhisperClientConfig.class
)
public interface GptWhisperClient {
    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    GPTResponse chat(@RequestBody GPTRequest GPTRequest);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperTranscriptionResponse createTranscription(@ModelAttribute WhisperTranscriptionRequest whisperTranscriptionRequest);

    @PostMapping(value = "${openai-service.urls.image-generation-url}", headers = {"Content-Type=application/json"})
    GenerateImageResponse generateImage(@RequestBody GenerateImageRequest request);

}
