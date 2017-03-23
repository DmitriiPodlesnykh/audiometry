package com.vsu.amm.medframe.dto;

public class DeviceDto {

    private Long id;

    private String soundCardName;

    private String headphoneName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoundCardName() {
        return soundCardName;
    }

    public void setSoundCardName(String soundCardName) {
        this.soundCardName = soundCardName;
    }

    public String getHeadphoneName() {
        return headphoneName;
    }

    public void setHeadphoneName(String headphoneName) {
        this.headphoneName = headphoneName;
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "id=" + id +
                ", soundCardName='" + soundCardName + '\'' +
                ", headphoneName='" + headphoneName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceDto deviceDto = (DeviceDto) o;

        if (id != null ? !id.equals(deviceDto.id) : deviceDto.id != null) return false;
        if (soundCardName != null ? !soundCardName.equals(deviceDto.soundCardName) : deviceDto.soundCardName != null)
            return false;
        return headphoneName != null ? headphoneName.equals(deviceDto.headphoneName) : deviceDto.headphoneName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (soundCardName != null ? soundCardName.hashCode() : 0);
        result = 31 * result + (headphoneName != null ? headphoneName.hashCode() : 0);
        return result;
    }
}
