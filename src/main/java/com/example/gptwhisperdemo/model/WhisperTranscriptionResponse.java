package com.example.gptwhisperdemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class WhisperTranscriptionResponse implements Serializable {
    private String text;
}
