package Jeju.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class MemberVo {

	private String email;
	private String password;
	private String nickname;
	private String phone;
	private String postcode;
	private String address;
	private String rank;
}
