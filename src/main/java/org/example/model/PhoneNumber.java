package org.example.model;

import com.squareup.wire.*;
import okio.ByteString;

import java.io.IOException;

public final class PhoneNumber extends Message<PhoneNumber, PhoneNumber.Builder> {
    private static final long serialVersionUID = 0L;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String iso2CountryCode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String subscriberNumber;

    public static final ProtoAdapter<PhoneNumber> ADAPTER =
            new ProtoAdapter_PhoneNumber();

    public PhoneNumber(String iso2CountryCode, String subscriberNumber) {
        this(iso2CountryCode, subscriberNumber, ByteString.EMPTY);
    }

    private PhoneNumber(String iso2CountryCode, String subscriberNumber, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.iso2CountryCode = iso2CountryCode;
        this.subscriberNumber = subscriberNumber;
    }

    public String getIso2CountryCode() {
        return iso2CountryCode;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public static final class Builder extends Message.Builder<PhoneNumber, Builder> {
        private String iso2CountryCode;
        private String subscriberNumber;

        public Builder iso2CountryCode(String iso2CountryCode) {
            this.iso2CountryCode = iso2CountryCode;
            return this;
        }

        public Builder subscriberNumber(String subscriberNumber) {
            this.subscriberNumber = subscriberNumber;
            return this;
        }

        @Override
        public PhoneNumber build() {
            return new PhoneNumber(iso2CountryCode, subscriberNumber, buildUnknownFields());
        }
    }

    public int hashCode() {
        int i5 = this.hashCode;
        if (i5 != 0) {
            return i5;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.iso2CountryCode;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.subscriberNumber;
        int hashCode3 = hashCode2 + (str2 != null ? str2.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }


    @Override
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.iso2CountryCode = this.iso2CountryCode;
        builder.subscriberNumber = this.subscriberNumber;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "iso2CountryCode='" + iso2CountryCode + '\'' +
                ", subscriberNumber='" + subscriberNumber + '\'' +
                '}';
    }

    private static final class ProtoAdapter_PhoneNumber extends ProtoAdapter<PhoneNumber> {
        ProtoAdapter_PhoneNumber() {
            super(FieldEncoding.LENGTH_DELIMITED, PhoneNumber.class);
        }

        @Override
        public int encodedSize(PhoneNumber value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.iso2CountryCode)
                    + ProtoAdapter.STRING.encodedSizeWithTag(2, value.subscriberNumber)
                    + value.unknownFields().size();
        }

        @Override
        public void encode(ProtoWriter writer, PhoneNumber value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.iso2CountryCode);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.subscriberNumber);
            writer.writeBytes(value.unknownFields());
        }

        @Override
        public PhoneNumber decode(ProtoReader reader) throws IOException {
            String iso2CountryCode = null;
            String subscriberNumber = null;

            long token = reader.beginMessage();
            while (true) {
                int tag = reader.nextTag();
                if (tag == -1) break;
                switch (tag) {
                    case 1:
                        iso2CountryCode = ProtoAdapter.STRING.decode(reader);
                        System.out.println("Tag: 1 (Field: iso2CountryCode), Type: STRING, Value: " + iso2CountryCode);
                        break;
                    case 2:
                        subscriberNumber = ProtoAdapter.STRING.decode(reader);
                        System.out.println("Tag: 2 (Field: subscriberNumber), Type: STRING, Value: " + subscriberNumber);
                        break;
                    default:
                        reader.readUnknownField(tag);
                        break;
                }
            }
            reader.endMessage(token);

            return new PhoneNumber(iso2CountryCode, subscriberNumber);
        }

        @Override
        public PhoneNumber redact(PhoneNumber value) {
            Builder builder = value.newBuilder();
            builder.clearUnknownFields();
            return builder.build();
        }
    }
}