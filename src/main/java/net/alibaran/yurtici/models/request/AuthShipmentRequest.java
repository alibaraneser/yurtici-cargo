package net.alibaran.yurtici.models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthShipmentRequest {

	private String wsUserName;

	private String wsPassword;

	private String wsLanguage;

	private String userLanguage;

}
