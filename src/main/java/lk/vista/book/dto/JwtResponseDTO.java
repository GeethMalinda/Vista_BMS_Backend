package lk.vista.book.dto;

public class JwtResponseDTO {


    private final String jwtToken;

    public JwtResponseDTO(String jwtToken) {

        this.jwtToken = jwtToken;
    }

    public String getToken() {

        return this.jwtToken;
    }
}
