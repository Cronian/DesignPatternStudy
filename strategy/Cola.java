public Class Cola{
    private BrandStrategy brandStrategy;
    private TasteStrategy tasteStratege;
    public void product() {
      brandStrategy.brand();
      tasteStratege.brand();
    }
}
