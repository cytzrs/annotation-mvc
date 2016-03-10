package busness;

import structs.form.ActionForm;

/**
 * Created by cytzr on 2016/1/19.
 */
public class AddUserForm extends ActionForm {

    public AddUserForm() {

    }

    private String name = "";
    private String pass = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
