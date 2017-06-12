package com.r3pi.booksexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDetailsJSONModel {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("volumeInfo")
    @Expose
    private VolumeInfo volumeInfo;
    @SerializedName("layerInfo")
    @Expose
    private LayerInfo layerInfo;
    @SerializedName("saleInfo")
    @Expose
    private SaleInfo saleInfo;
    @SerializedName("accessInfo")
    @Expose
    private AccessInfo accessInfo;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public LayerInfo getLayerInfo() {
        return layerInfo;
    }

    public void setLayerInfo(LayerInfo layerInfo) {
        this.layerInfo = layerInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }


    public class VolumeInfo {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("authors")
        @Expose
        private List<String> authors = null;
        @SerializedName("publisher")
        @Expose
        private String publisher;
        @SerializedName("publishedDate")
        @Expose
        private String publishedDate;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("industryIdentifiers")
        @Expose
        private List<IndustryIdentifier> industryIdentifiers = null;
        @SerializedName("pageCount")
        @Expose
        private Integer pageCount;
        @SerializedName("printedPageCount")
        @Expose
        private Integer printedPageCount;
        @SerializedName("printType")
        @Expose
        private String printType;
        @SerializedName("categories")
        @Expose
        private List<String> categories = null;
        @SerializedName("averageRating")
        @Expose
        private Double averageRating;
        @SerializedName("ratingsCount")
        @Expose
        private Integer ratingsCount;
        @SerializedName("maturityRating")
        @Expose
        private String maturityRating;
        @SerializedName("allowAnonLogging")
        @Expose
        private Boolean allowAnonLogging;
        @SerializedName("contentVersion")
        @Expose
        private String contentVersion;
        @SerializedName("panelizationSummary")
        @Expose
        private PanelizationSummary panelizationSummary;
        @SerializedName("imageLinks")
        @Expose
        private ImageLinks imageLinks;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("previewLink")
        @Expose
        private String previewLink;
        @SerializedName("infoLink")
        @Expose
        private String infoLink;
        @SerializedName("canonicalVolumeLink")
        @Expose
        private String canonicalVolumeLink;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<IndustryIdentifier> getIndustryIdentifiers() {
            return industryIdentifiers;
        }

        public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
            this.industryIdentifiers = industryIdentifiers;
        }


        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getPrintedPageCount() {
            return printedPageCount;
        }

        public void setPrintedPageCount(Integer printedPageCount) {
            this.printedPageCount = printedPageCount;
        }

        public String getPrintType() {
            return printType;
        }

        public void setPrintType(String printType) {
            this.printType = printType;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public Double getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(Double averageRating) {
            this.averageRating = averageRating;
        }

        public Integer getRatingsCount() {
            return ratingsCount;
        }

        public void setRatingsCount(Integer ratingsCount) {
            this.ratingsCount = ratingsCount;
        }

        public String getMaturityRating() {
            return maturityRating;
        }

        public void setMaturityRating(String maturityRating) {
            this.maturityRating = maturityRating;
        }

        public Boolean getAllowAnonLogging() {
            return allowAnonLogging;
        }

        public void setAllowAnonLogging(Boolean allowAnonLogging) {
            this.allowAnonLogging = allowAnonLogging;
        }

        public String getContentVersion() {
            return contentVersion;
        }

        public void setContentVersion(String contentVersion) {
            this.contentVersion = contentVersion;
        }

        public PanelizationSummary getPanelizationSummary() {
            return panelizationSummary;
        }

        public void setPanelizationSummary(PanelizationSummary panelizationSummary) {
            this.panelizationSummary = panelizationSummary;
        }

        public ImageLinks getImageLinks() {
            return imageLinks;
        }

        public void setImageLinks(ImageLinks imageLinks) {
            this.imageLinks = imageLinks;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getPreviewLink() {
            return previewLink;
        }

        public void setPreviewLink(String previewLink) {
            this.previewLink = previewLink;
        }

        public String getInfoLink() {
            return infoLink;
        }

        public void setInfoLink(String infoLink) {
            this.infoLink = infoLink;
        }

        public String getCanonicalVolumeLink() {
            return canonicalVolumeLink;
        }

        public void setCanonicalVolumeLink(String canonicalVolumeLink) {
            this.canonicalVolumeLink = canonicalVolumeLink;
        }

    }

    public class SaleInfo {

        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("saleability")
        @Expose
        private String saleability;
        @SerializedName("isEbook")
        @Expose
        private Boolean isEbook;
        @SerializedName("listPrice")
        @Expose
        private ListPrice listPrice;
        @SerializedName("retailPrice")
        @Expose
        private RetailPrice retailPrice;
        @SerializedName("buyLink")
        @Expose
        private String buyLink;
        @SerializedName("offers")
        @Expose
        private List<Offer> offers = null;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getSaleability() {
            return saleability;
        }

        public void setSaleability(String saleability) {
            this.saleability = saleability;
        }

        public Boolean getIsEbook() {
            return isEbook;
        }

        public void setIsEbook(Boolean isEbook) {
            this.isEbook = isEbook;
        }

        public ListPrice getListPrice() {
            return listPrice;
        }

        public void setListPrice(ListPrice listPrice) {
            this.listPrice = listPrice;
        }

        public RetailPrice getRetailPrice() {
            return retailPrice;
        }

        public void setRetailPrice(RetailPrice retailPrice) {
            this.retailPrice = retailPrice;
        }

        public String getBuyLink() {
            return buyLink;
        }

        public void setBuyLink(String buyLink) {
            this.buyLink = buyLink;
        }

        public List<Offer> getOffers() {
            return offers;
        }

        public void setOffers(List<Offer> offers) {
            this.offers = offers;
        }

    }

    public class RetailPrice_ {

        @SerializedName("amountInMicros")
        @Expose
        private Double amountInMicros;
        @SerializedName("currencyCode")
        @Expose
        private String currencyCode;

        public Double getAmountInMicros() {
            return amountInMicros;
        }

        public void setAmountInMicros(Double amountInMicros) {
            this.amountInMicros = amountInMicros;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

    }

    public class RetailPrice {

        @SerializedName("amount")
        @Expose
        private Double amount;
        @SerializedName("currencyCode")
        @Expose
        private String currencyCode;

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

    }

    public class Pdf {

        @SerializedName("isAvailable")
        @Expose
        private Boolean isAvailable;
        @SerializedName("acsTokenLink")
        @Expose
        private String acsTokenLink;

        public Boolean getIsAvailable() {
            return isAvailable;
        }

        public void setIsAvailable(Boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        public String getAcsTokenLink() {
            return acsTokenLink;
        }

        public void setAcsTokenLink(String acsTokenLink) {
            this.acsTokenLink = acsTokenLink;
        }

    }

    public class PanelizationSummary {

        @SerializedName("containsEpubBubbles")
        @Expose
        private Boolean containsEpubBubbles;
        @SerializedName("containsImageBubbles")
        @Expose
        private Boolean containsImageBubbles;

        public Boolean getContainsEpubBubbles() {
            return containsEpubBubbles;
        }

        public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
            this.containsEpubBubbles = containsEpubBubbles;
        }

        public Boolean getContainsImageBubbles() {
            return containsImageBubbles;
        }

        public void setContainsImageBubbles(Boolean containsImageBubbles) {
            this.containsImageBubbles = containsImageBubbles;
        }

    }

    public class Offer {

        @SerializedName("finskyOfferType")
        @Expose
        private Integer finskyOfferType;
        @SerializedName("listPrice")
        @Expose
        private ListPrice_ listPrice;
        @SerializedName("retailPrice")
        @Expose
        private RetailPrice_ retailPrice;
        @SerializedName("giftable")
        @Expose
        private Boolean giftable;

        public Integer getFinskyOfferType() {
            return finskyOfferType;
        }

        public void setFinskyOfferType(Integer finskyOfferType) {
            this.finskyOfferType = finskyOfferType;
        }

        public ListPrice_ getListPrice() {
            return listPrice;
        }

        public void setListPrice(ListPrice_ listPrice) {
            this.listPrice = listPrice;
        }

        public RetailPrice_ getRetailPrice() {
            return retailPrice;
        }

        public void setRetailPrice(RetailPrice_ retailPrice) {
            this.retailPrice = retailPrice;
        }

        public Boolean getGiftable() {
            return giftable;
        }

        public void setGiftable(Boolean giftable) {
            this.giftable = giftable;
        }

    }

    public class ListPrice_ {

        @SerializedName("amountInMicros")
        @Expose
        private Double amountInMicros;
        @SerializedName("currencyCode")
        @Expose
        private String currencyCode;

        public Double getAmountInMicros() {
            return amountInMicros;
        }

        public void setAmountInMicros(Double amountInMicros) {
            this.amountInMicros = amountInMicros;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

    }

    public class ListPrice {

        @SerializedName("amount")
        @Expose
        private Double amount;
        @SerializedName("currencyCode")
        @Expose
        private String currencyCode;

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

    }

    public class LayerInfo {

        @SerializedName("layers")
        @Expose
        private List<Layer> layers = null;

        public List<Layer> getLayers() {
            return layers;
        }

        public void setLayers(List<Layer> layers) {
            this.layers = layers;
        }

    }

    public class Layer {

        @SerializedName("layerId")
        @Expose
        private String layerId;
        @SerializedName("volumeAnnotationsVersion")
        @Expose
        private String volumeAnnotationsVersion;

        public String getLayerId() {
            return layerId;
        }

        public void setLayerId(String layerId) {
            this.layerId = layerId;
        }

        public String getVolumeAnnotationsVersion() {
            return volumeAnnotationsVersion;
        }

        public void setVolumeAnnotationsVersion(String volumeAnnotationsVersion) {
            this.volumeAnnotationsVersion = volumeAnnotationsVersion;
        }

    }public class IndustryIdentifier {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("identifier")
        @Expose
        private String identifier;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

    }

    public class ImageLinks {

        @SerializedName("smallThumbnail")
        @Expose
        private String smallThumbnail;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;
        @SerializedName("extraLarge")
        @Expose
        private String extraLarge;

        public String getSmallThumbnail() {
            return smallThumbnail;
        }

        public void setSmallThumbnail(String smallThumbnail) {
            this.smallThumbnail = smallThumbnail;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getExtraLarge() {
            return extraLarge;
        }

        public void setExtraLarge(String extraLarge) {
            this.extraLarge = extraLarge;
        }

    }

    public class Epub {

        @SerializedName("isAvailable")
        @Expose
        private Boolean isAvailable;
        @SerializedName("acsTokenLink")
        @Expose
        private String acsTokenLink;

        public Boolean getIsAvailable() {
            return isAvailable;
        }

        public void setIsAvailable(Boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        public String getAcsTokenLink() {
            return acsTokenLink;
        }

        public void setAcsTokenLink(String acsTokenLink) {
            this.acsTokenLink = acsTokenLink;
        }

    }

    public class AccessInfo {

        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("viewability")
        @Expose
        private String viewability;
        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("publicDomain")
        @Expose
        private Boolean publicDomain;
        @SerializedName("textToSpeechPermission")
        @Expose
        private String textToSpeechPermission;
        @SerializedName("epub")
        @Expose
        private Epub epub;
        @SerializedName("pdf")
        @Expose
        private Pdf pdf;
        @SerializedName("webReaderLink")
        @Expose
        private String webReaderLink;
        @SerializedName("accessViewStatus")
        @Expose
        private String accessViewStatus;
        @SerializedName("quoteSharingAllowed")
        @Expose
        private Boolean quoteSharingAllowed;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getViewability() {
            return viewability;
        }

        public void setViewability(String viewability) {
            this.viewability = viewability;
        }

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public Boolean getPublicDomain() {
            return publicDomain;
        }

        public void setPublicDomain(Boolean publicDomain) {
            this.publicDomain = publicDomain;
        }

        public String getTextToSpeechPermission() {
            return textToSpeechPermission;
        }

        public void setTextToSpeechPermission(String textToSpeechPermission) {
            this.textToSpeechPermission = textToSpeechPermission;
        }

        public Epub getEpub() {
            return epub;
        }

        public void setEpub(Epub epub) {
            this.epub = epub;
        }

        public Pdf getPdf() {
            return pdf;
        }

        public void setPdf(Pdf pdf) {
            this.pdf = pdf;
        }

        public String getWebReaderLink() {
            return webReaderLink;
        }

        public void setWebReaderLink(String webReaderLink) {
            this.webReaderLink = webReaderLink;
        }

        public String getAccessViewStatus() {
            return accessViewStatus;
        }

        public void setAccessViewStatus(String accessViewStatus) {
            this.accessViewStatus = accessViewStatus;
        }

        public Boolean getQuoteSharingAllowed() {
            return quoteSharingAllowed;
        }

        public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
            this.quoteSharingAllowed = quoteSharingAllowed;
        }

    }


}
