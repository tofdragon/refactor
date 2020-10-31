package weathermachine;

/**
 * @author sunjing
 */
public interface WeatherObserver {

    /**
     * 通知
     *
     * @param changeEvent 改变事件
     */
    void observer(ChangeEvent changeEvent);
}
