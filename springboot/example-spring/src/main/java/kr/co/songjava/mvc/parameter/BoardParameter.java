package kr.co.songjava.mvc.parameter;

import java.util.Date;
import lombok.Data;


@Data
public class BoardParameter {
	private int boardSeq;
	private String title;
	private String contents;
}
