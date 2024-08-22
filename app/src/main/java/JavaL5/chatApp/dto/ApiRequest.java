package JavaL5.chatApp.dto;


import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiRequest {

    private int userID;
    private int roomID;
}
