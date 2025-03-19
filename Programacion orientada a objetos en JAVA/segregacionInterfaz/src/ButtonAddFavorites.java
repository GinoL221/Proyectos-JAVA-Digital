public class ButtonAddFavorites implements OnClickListener{

    private String text;
    private String color;
    private Boolean itsMarked;

    public ButtonAddFavorites(String text) {
        this.text = text;
        this.color = "Gray";
        this.itsMarked = false;
    }

    @Override
    public void onClick() {
        if(!itsMarked){
            this.color = "Red";
            this.itsMarked = true;
        }else{
            this.color = "Gray";
            this.itsMarked = false;
        }
    }
}
