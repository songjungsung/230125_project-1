package hotel.dto;

import lombok.Data;

@Data
public class AskDto {

	private int askIdx;
    private String title;
    private String contents;
    private int hitCnt;
    private String registDt;
    private String registId;
    private String updatedDt;
    private String updatedId;
}
