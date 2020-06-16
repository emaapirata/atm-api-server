package net.emamarquez.atms.atmapi.util;


public class ResponseTransfer {
    private boolean ok;
    private Object result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public ResponseTransfer(boolean ok, Object result) {
        this.ok = ok;
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
