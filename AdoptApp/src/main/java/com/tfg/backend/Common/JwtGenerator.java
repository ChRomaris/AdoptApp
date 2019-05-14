package com.tfg.backend.Common;

public interface JwtGenerator {

	String generate(JwtInfo info);

	JwtInfo getInfo(String token);

}
