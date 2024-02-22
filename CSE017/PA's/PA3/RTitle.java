import java.time.LocalDate;

public class RTitle {

    private Title restoredTitle;
    private LocalDate restorationDate;

    public RTitle(Title restoredTitle) {
        this.restoredTitle = restoredTitle.clone();
        this.restorationDate = LocalDate.now();
    }

    public Object getRestoredTitle() {
        throw new UnsupportedOperationException("Unimplemented method 'getRestoredTitle'");
    }
}
