package com.sid.demospringcloudstreamskafka.entities;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageEvent {
    private String name;
    private String user;
    private Date datevisite;
    private long duration;
}
