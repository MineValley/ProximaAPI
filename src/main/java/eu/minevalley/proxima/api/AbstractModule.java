package eu.minevalley.proxima.api;

@SuppressWarnings("unused")
public abstract class AbstractModule {

    /**
     * Is called when the module is enabled.
     */
    public void onEnable() {
        // override this method to add logic
    }

    /**
     * Is called when the module is disabled.
     */
    public void onDisable() {
        // override this method to add logic
    }
}