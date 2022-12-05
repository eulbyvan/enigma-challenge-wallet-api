package com.enigmacamp.model.response;

import com.enigmacamp.model.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse extends CommonResponse {
	String data;

	public SuccessResponse(String code, String status, String msg, String data) {
		super.setCode(code);
		super.setStatus(status);
		super.setMsg(msg);
		this.data = data;
	}
}
