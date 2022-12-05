package com.enigmacamp;

import com.enigmacamp.model.Wallet;
import com.enigmacamp.model.response.CommonResponse;
import com.enigmacamp.model.response.ErrorResponse;
import com.enigmacamp.model.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@RestController
@RequestMapping
public class WalletController {
	@PostMapping("/wallet-payment")
	public ResponseEntity<CommonResponse> add(@RequestBody Wallet req) {
		if (req.getCustomerId().equals("123") && req.getTrxId().equals("123") && req.getTrxType().equalsIgnoreCase("payment")) {
			SuccessResponse res = new SuccessResponse("00", "OK", "Success payment", UUID.randomUUID().toString());

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		ErrorResponse res = new ErrorResponse();

		res.setCode("X01");
		res.setStatus("FAILED");

		if (!req.getCustomerId().equals("123")) {
			res.setMsg("Customer ID is unknown");
		} else if (!req.getTrxId().equals("123")) {
			res.setMsg("Transaction ID is unknown");
		} else if (!req.getCustomerId().equals("PAYMENT")) {
			res.setMsg("Transaction type is unknown");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
}
