package requests;

import groovyjarjarantlr4.v4.codegen.model.decl.CodeBlock;

public class CourierCreateReq extends CourierLoginReq {
    private String firstName;

    public CourierCreateReq(String login, String password, String firstName) {
        super(login, password);
        this.firstName = firstName;
    }

    public CourierCreateReq() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
