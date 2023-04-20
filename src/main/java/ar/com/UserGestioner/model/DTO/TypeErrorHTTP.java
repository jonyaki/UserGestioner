package ar.com.UserGestioner.model.DTO;

import java.util.Date;

public class TypeErrorHTTP {
    private long timestamp;
    private int codigo;
    private String detalle;

    public TypeErrorHTTP(long timeStamp,int codigo, String detalle) {
        this.timestamp = timeStamp;
        this.codigo = codigo;
        this.detalle = detalle;
    }
    public TypeErrorHTTP(int codigo, String detalle) {
        this.timestamp = new Date().getTime();
        this.codigo = codigo;
        this.detalle = detalle;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDetalle() {
        return detalle;
    }
}
