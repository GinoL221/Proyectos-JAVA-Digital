public class Main {
    public static void main(String[] args) {
        ButtonLogin buttonLogin = new ButtonLogin("Gray");
        buttonLogin.onClick();
        buttonLogin.onLongClick();

        ButtonAddFavorites buttonAddFavorites = new ButtonAddFavorites("Add to favorites");
        buttonAddFavorites.onClick();
        buttonAddFavorites.onClick();
        buttonAddFavorites.onClick();
    }
}