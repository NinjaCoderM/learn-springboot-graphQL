package at.codecrafters.learn_springboot_graphql.config;

public class GraphQLExceptionEx extends RuntimeException {
    private String code;

    public GraphQLExceptionEx(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
