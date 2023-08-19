package com.example.gptwhisperdemo.service;

import com.example.gptwhisperdemo.gptWhisperClient.GptWhisperClient;
import com.example.gptwhisperdemo.gptWhisperClient.GptWhisperClientConfig;
import com.example.gptwhisperdemo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class GptWhisperService {
    private final GptWhisperClient gptWhisperClient;
    private final GptWhisperClientConfig gptWhisperClientConfig;

    private final static String ROLE_USER = "user";

    public GPTResponse chat(ChatRequest chatRequest){
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(chatRequest.getQuestion())
                .build();
        GPTRequest gptRequest = GPTRequest.builder()
                .model(gptWhisperClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        return gptWhisperClient.chat(gptRequest);
    }

    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest){
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
                .model(gptWhisperClientConfig.getAudioModel())
                .file(transcriptionRequest.getFile())
                .build();
        return gptWhisperClient.createTranscription(whisperTranscriptionRequest);
    }

    public GenerateImageResponse generateImage(GenerateImageRequest request) {
        GenerateImageRequest generateImageRequest = GenerateImageRequest.builder()
                .prompt(request.getPrompt())
                .build();
        return gptWhisperClient.generateImage(generateImageRequest);
    }
}
