package com.cye.dms.entity;



@Entity
@Table(name = "request_logs")   
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLogs {

private Long id;
private String Url;
private String method;
private String requestIp;
@Column(columnDefinition = "TEXT")
private String requestBody

private Integer responseStatus;
@Column(columnDefination = "TEXT")
private String responseBody;
private LocalDateTime timeStamp;
}
