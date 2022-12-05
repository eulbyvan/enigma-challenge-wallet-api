package com.enigmacamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
	private String customerId;
	private String trxId;
	private String trxType;
}