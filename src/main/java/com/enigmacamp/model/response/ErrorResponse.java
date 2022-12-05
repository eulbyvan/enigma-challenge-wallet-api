package com.enigmacamp.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Data
@NoArgsConstructor
public class ErrorResponse extends CommonResponse{
	public ErrorResponse(String code, String status, String msg) {
		super.setCode(code);
		super.setStatus(status);
		super.setMsg(msg);
	}
}
