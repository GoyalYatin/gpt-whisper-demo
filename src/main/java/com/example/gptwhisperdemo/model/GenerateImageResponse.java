package com.example.gptwhisperdemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GenerateImageResponse implements Serializable {
    private long created;
    private List<GeneratedImage> data;
}
