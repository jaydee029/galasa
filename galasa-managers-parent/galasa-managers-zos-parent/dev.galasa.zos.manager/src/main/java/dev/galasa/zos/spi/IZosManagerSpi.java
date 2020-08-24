/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.zos.spi;

import javax.validation.constraints.NotNull;

import dev.galasa.zos.IZosImage;
import dev.galasa.zos.IZosManager;
import dev.galasa.zos.ZosManagerException;
import dev.galasa.zosbatch.ZosBatchManagerException;

public interface IZosManagerSpi extends IZosManager {
    
    /**
     * Returns a zOS Image for the specified tag, if necessary provisions it
     * @param tag the tag of the image
     * @return and image, never null
     * @throws ZosManagerException if the tag is missing
     */
    @NotNull
    IZosImage provisionImageForTag(@NotNull String tag) throws ZosManagerException;

    /**
     * Returns a zOS Image for the specified tag
     * @param tag the tag of the image
     * @return and image, never null
     * @throws ZosManagerException if the tag is missing
     */
    @NotNull
    IZosImage getImageForTag(@NotNull String tag) throws ZosManagerException;

    /**
     * Returns a zOS Image for the specified image ID
     * @param image the ID of the image
     * @return the image, never null
     * @throws ZosManagerException
     */
    @NotNull
    IZosImage getImage(String imageId) throws ZosManagerException;

    /**
     * Returns a zOS Image for the specified image that may not have been provisioned so far
     * @param image the ID of the image
     * @return the image, never null
     * @throws ZosManagerException if there is no image defined
     */
    @NotNull
    IZosImage getUnmanagedImage(String imageId) throws ZosManagerException;

    /**
     * Returns the data set HLQ(s) for temporary data sets for the specified image
     * @param the image
     * @return the image, never null
     * @throws ZosManagerException
     */
    @NotNull
    String getRunDatasetHLQ(IZosImage image) throws ZosManagerException;

    /**
     * Provides other managers to the zOS Batch {@code zosbatch.batchjob.[imageid].restrict.to.image} property
     * @param imageId
     * @return
     * @throws ZosBatchManagerException
     */
	boolean getZosBatchPropertyRestrictToImage(String imageId) throws ZosBatchManagerException;

	/**
	 * Provides other managers to the zOS Batch {@code zosbatch.batchjob.[imageid].use.sysaff} property
	 * @param imageId
	 * @return
	 * @throws ZosBatchManagerException
	 */
	boolean getZosBatchPropertyUseSysaff(String imageId) throws ZosBatchManagerException;
	
	/**
	 * Provides other managers to the zOS Batch {@code zosbatch.batchjob.[imageid].timeout} property
	 * @param imageId
	 * @return
	 * @throws ZosBatchManagerException
	 */
	int getZosBatchPropertyJobWaitTimeout(String imageId) throws ZosBatchManagerException;

	/**
	 * Provides other managers to the zOS Batch {@code zosbatch.batchjob.[imageid].truncate.jcl.records} property
	 * @param imageId
	 * @return
	 * @throws ZosBatchManagerException
	 */
	boolean getZosBatchPropertyTruncateJCLRecords(String imageId) throws ZosBatchManagerException;

	/**
	 * Provides other managers to the zOS Batch {@code zosbatch.jobname.[imageid].prefix} property
	 * @param imageId
	 * @return
	 * @throws ZosBatchManagerException
	 */
	String getZosBatchPropertyJobnamePrefix(String imageId) throws ZosBatchManagerException;

}
