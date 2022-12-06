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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
		String s = UUID.randomUUID().toString();

		List<String> data = List.of(s);

		if (req.getCustomerId().equals("123") && req.getTrxId().equals("123") && req.getTrxType().equalsIgnoreCase("payment")) {
			SuccessResponse res = new SuccessResponse("00", "OK", "Success payment", data);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}

		ErrorResponse res = new ErrorResponse();

		res.setStatus("FAILED");

		if (!req.getCustomerId().equals("123")) {
			res.setCode("X01");
			res.setMsg("Customer ID doesn't exist");
		} else if (!req.getTrxId().equals("123")) {
			res.setCode("X02");
			res.setMsg("Transaction ID doesn't exist");
		} else if (!req.getCustomerId().equals("PAYMENT")) {
			res.setCode("X03");
			res.setMsg("Transaction type is unknown");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}
}
