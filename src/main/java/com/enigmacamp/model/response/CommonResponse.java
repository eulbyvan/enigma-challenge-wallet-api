package com.enigmacamp.model.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Data
public abstract class CommonResponse {
	private String code;
	private String status;
	private String msg;
}
