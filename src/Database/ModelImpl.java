package ProofOfConcept.Database;

public class ModelImpl implements Model  {


    private DatabaseInterface databaseInterface;

    public ModelImpl(DatabaseInterface databaseInterface){
        this.databaseInterface = databaseInterface;
    }

    @Override
    public String getBook(String title) {
       return databaseInterface.getBook(title);
    }
}
