public class PepsiBrand implements BrandStrategy {
    private String brand;
    public PepsiBrand() {
      this.brand = "Pepsi Cola";
    }
    
    public void brand() {
      System.out.println(this.brand); 
    }
}
