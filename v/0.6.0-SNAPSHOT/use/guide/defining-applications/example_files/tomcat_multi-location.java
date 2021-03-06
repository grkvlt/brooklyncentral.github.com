// TODO Untested code; see brooklyn-example for better maintained examples!
public class TomcatFabricApp extends AbstractApplication {
    @Override
    public void init() {
        addChild(EntitySpecs.spec(DynamicFabric.class)
                .configure("displayName", "WebFabric")
                .configure("displayNamePrefix", "")
                .configure("displayNameSuffix", " web cluster")
                .configure("memberSpec", EntitySpecs.spec(ControlledDynamicWebAppCluster.class)
                        .configure("initialSize", 2)
                        .configure("memberSpec", : EntitySpecs.spec(TomcatServer.class)
                                .configure("httpPort", "8080+")
                                .configure("war", "/path/to/booking-mvc.war"))));
    }
}
