public Class Cola{
    private BrandStrategy brandStrategy;
    public void brand() {
      brandStrategy.brand();
    }
    
    public void setBrand(BrandStrategy brand) {
        this.brandStrategy = brand;
    }
}
