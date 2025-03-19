public class ButtonLogin implements OnClickListener, OnLongClickListener {

    private String text;
    private String color;

    public ButtonLogin(String color) {
        this.text = "Login";
        this.color = color;
    }

    @Override
    public void onClick() {
        System.out.println("Login button clicked");
    }

    @Override
    public void onLongClick() {
        System.out.println("Login button long clicked");
    }
}
