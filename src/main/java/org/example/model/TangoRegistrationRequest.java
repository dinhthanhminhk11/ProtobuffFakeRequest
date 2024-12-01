package org.example.model;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import okio.ByteString;

public final class TangoRegistrationRequest extends Message {
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    private String accountId;

    protected TangoRegistrationRequest(ProtoAdapter adapter, ByteString unknownFields) {
        super(adapter, unknownFields);
    }

    @Override
    public Builder newBuilder() {
        return null;
    }
}