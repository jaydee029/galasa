/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.framework.api.common;

public enum ServletErrorMessage {

    // RunQuery...
    GAL5001_INVALID_DATE_TIME_FIELD                   (5001,"E: Error parsing the date-time field ''{0}'' in the request URL. Invalid value ''{1}''. Expecting a java LocalDateTime format. For example: ''2023-04-11T09:42:06.589180Z''"),
    GAL5002_INVALID_RUN_ID                            (5002,"E: Error retrieving ras run from identifier ''{0}''."),
    GAL5003_ERROR_RETRIEVING_RUNS                     (5003,"E: Error retrieving runs. Report the problem to your Galasa Ecosystem owner."),
    GAL5004_ERROR_RETRIEVING_PAGE                     (5004,"E: Error retrieving page. Report the problem to your Galasa Ecosystem owner."),
    GAL5005_INVALID_QUERY_PARAM_NOT_INTEGER           (5005,"E: Error parsing the query parameter ''{0}'' in the request URL. Invalid value ''{1}''. Expecting an integer."),
    GAL5006_INVALID_QUERY_PARAM_DUPLICATES            (5006,"E: Error parsing the query parameters. Duplicate instances of query parameter ''{0}'' found in the request URL. Expecting only one."),

    GAL5010_FROM_DATE_IS_REQUIRED                     (5010,"E: Error parsing the query parameters. 'from' time is a mandatory field if no 'runname' is supplied."),
    GAL5011_SORT_VALUE_NOT_RECOGNIZED                 (5011,"E: Error parsing the query parameters. 'sort' value ''{0}'' not recognised. Expected query parameter in the format 'sort={fieldName}:{order}' where order is 'asc' for ascending or 'desc' for descending."),
    GAL5012_SORT_VALUE_MISSING                        (5012,"E: Error parsing the query parameters. 'sort' value was not supplied. Expected query parameter in the format 'sort={fieldName}:{order}' where order is 'asc' for ascending or 'desc' for descending."),
    GAL5013_RESULT_NAME_NOT_RECOGNIZED                (5013,"E: Error parsing the query parameters. 'result' value ''{0}'' not recognised. Expected result name to match one of the following ''{1}''."),
    GAL5014_STATUS_NAME_NOT_RECOGNIZED                (5014,"E: Error parsing the query parameters. 'status' value ''{0}'' not recognised. Expected status name to match one of the following ''{1}''."),

    // RunArtifactsList...
    GAL5007_ERROR_RETRIEVING_ARTIFACTS_LIST           (5007,"E: Error retrieving artifacts for run with identifier ''{0}''."),

    // RunArtifactsDownload...
    GAL5008_ERROR_LOCATING_ARTIFACT                   (5008,"E: Error locating artifact ''{0}'' for run with identifier ''{1}''."),
    GAL5009_ERROR_RETRIEVING_ARTIFACT                 (5009,"E: Error retrieving artifact ''{0}'' for run with identifier ''{1}''."),

    // GenericErrors...
    GAL5000_GENERIC_API_ERROR                         (5000,"E: Error occured when trying to access the endpoint. Report the problem to your Galasa Ecosystem owner."),
    GAL5400_BAD_REQUEST                               (5400,"E: Error occured when trying to execute request ''{0}''. Please check your request parameters or report the problem to your Galasa Ecosystem owner."),
    GAL5401_UNAUTHORIZED                              (5401,"E: Unauthorized. Please ensure you have provided a valid 'Authorization' header with a valid bearer token and try again."),
    GAL5404_UNRESOLVED_ENDPOINT_ERROR                 (5404,"E: Error occured when trying to identify the endpoint ''{0}''. Please check your endpoint URL or report the problem to your Galasa Ecosystem owner."),
    GAL5405_METHOD_NOT_ALLOWED                        (5405,"E: Error occured when trying to access the endpoint ''{0}''. The method ''{1}'' is not allowed."),
    GAL5411_NO_REQUEST_BODY                           (5411,"E: Error occured when trying to access the endpoint ''{0}''. The request body is empty."),

    //CPS Namespaces...
    GAL5015_INTERNAL_CPS_ERROR                        (5015,"E: Error occured when trying to access the Configuration Property Store. Report the problem to your Galasa Ecosystem owner."),
    GAL5016_INVALID_NAMESPACE_ERROR                   (5016,"E: Error occured when trying to access namespace ''{0}''. The namespace provided is invalid."),
    GAL5017_PROPERTY_DOES_NOT_EXIST_ERROR             (5017,"E: Error occured when trying to access property ''{0}''. The property does not exist."),
    GAL5018_PROPERTY_ALREADY_EXISTS_ERROR             (5018,"E: Error occured when trying to access property ''{0}''. The property name provided already exists in the ''{1}'' namespace."),
    GAL5028_PROPERTY_NAMESPACE_DOES_NOT_MATCH_ERROR   (5028,"E: The GalasaProperty namespace ''{0}'' must match the url namespace ''{1}''."),
    GAL5029_PROPERTY_NAME_DOES_NOT_MATCH_ERROR        (5029,"E: The GalasaProperty name ''{0}'' must match the url namespace ''{1}''."),
    GAL5030_UNABLE_TO_DELETE_PROPERTY_ERROR           (5030,"E: Error occured when trying to delete Property ''{0}''. Report the problem to your Galasa Ecosystem owner."),

    //Schedule Runs...
    GAL5019_UNABLE_TO_RETRIEVE_RUNS                   (5019, "E: Unable to retrieve runs for Run Group: ''{0}''."),
    GAL5020_UNABLE_TO_CONVERT_TO_SCHEDULE_REQUEST     (5020, "E: Error occured when trying to translate the payload into a run."),
    GAL5021_UNABLE_TO_SUBMIT_RUNS                     (5021, "E: Error occured when trying to submit run ''{0}''."),
    GAL5022_UNABLE_TO_PARSE_SHARED_ENVIRONMENT_PHASE  (5022, "E: Error occured trying parse the sharedEnvironmentPhase ''{0}''. Valid options are 'BUILD', 'DISCARD'."),

    //Galasa Property...
    GAL5023_UNABLE_TO_CAST_TO_GALASAPROPERTY          (5023, "E: Error occured trying to interpret resource ''{0}''. P This could indicate a mis-match between client and server levels. Please check with your Ecosystem administrator the level. You may have to upgrade/downgrade your client program."),
    GAL5024_INVALID_GALASAPROPERTY                    (5024, "E: Error occured because the Galasa Property is invalid. ''{0}''"),
    GAL5031_EMPTY_NAMESPACE                           (5031, "E: Invalid namespace. Namespace is empty."),
    GAL5032_INVALID_FIRST_CHARACTER_NAMESPACE         (5032, "E: Invalid namespace name. ''{0}'' must not start with the ''{1}'' character. Allowable first characters are 'a'-'z' or 'A'-'Z'."),
    GAL5033_INVALID_NAMESPACE_INVALID_MIDDLE_CHAR     (5033, "E: Invalid namespace name. ''{0}'' must not contain the ''{1}'' character. Allowable characters after the first character are 'a'-'z', 'A'-'Z', '0'-'9'."),
    GAL5034_INVALID_PREFIX_MISSING_OR_EMPTY           (5034, "E: Invalid property name prefix. Prefix is missing or empty."),
    GAL5035_INVALID_FIRST_CHAR_PROPERTY_NAME_PREFIX   (5035, "E: Invalid property name prefix. ''{0}'' must not start with the ''{1}'' character. Allowable first characters are 'a'-'z' or 'A'-'Z'."),
    GAL5036_INVALID_PROPERTY_NAME_PREFIX_INVALID_CHAR (5036, "E: Invalid property name prefix. ''{0}'' must not contain the ''{1}'' character. Allowable characters after the first character are 'a'-'z', 'A'-'Z', '0'-'9', '-' (dash), '.' (dot) and '_' (underscore)."),
    GAL5037_INVALID_PROPERTY_NAME_SUFFIX_EMPTY        (5037, "E: Invalid property name. Property name is missing or empty."),
    GAL5038_INVALID_PROPERTY_NAME_SUFFIX_FIRST_CHAR   (5038, "E: Invalid property name suffix. ''{0}'' must not start with the ''{1}'' character. Allowable first characters are 'a'-'z' or 'A'-'Z'."),
    GAL5039_INVALID_PROPERTY_NAME_SUUFIX_INVALID_CHAR (5039, "E: Invalid property name suffix. ''{0}'' must not contain the ''{1}'' character. Allowable characters after the first character are 'a'-'z', 'A'-'Z', '0'-'9', '-' (dash), '.' (dot) and '_' (underscore)."),
    GAL5040_INVALID_PROPERTY_NAME_EMPTY               (5040, "E: Invalid property name. Property name is missing or empty."),
    GAL5041_INVALID_PROPERTY_NAME_FIRST_CHAR          (5041, "E: Invalid property name. ''{0}'' must not start with the ''{1}'' character. Allowable first characters are 'a'-'z' or 'A'-'Z'."),
    GAL5042_INVALID_PROPERTY_NAME_INVALID_CHAR        (5042, "E: Invalid property name. ''{0}'' must not contain the ''{1}'' character. Allowable characters after the first character are 'a'-'z', 'A'-'Z', '0'-'9', '-' (dash), '.' (dot) and '_' (underscore)"),
    GAL5043_INVALID_PROPERTY_NAME_NO_DOT_SEPARATOR    (5043, "E: Invalid property name. Property name ''{0}'' much have at least two parts seperated by a '.' (dot)."),
    GAL5044_INVALID_PROPERTY_NAME_TRAILING_DOT        (5044, "E: Invalid property name. Property name ''{0}'' must not end with a '.' (dot) seperator."),
    
    //Resources APIs...
    GAL5025_UNSUPPORTED_ACTION                        (5025, "E: Error occured. The field 'action' in the request body is invalid. The 'action' value''{0}'' supplied is not supported. Supported actions are: create, apply and update. This could indicate a mis-match between client and server levels. Please check with your Ecosystem administrator the level. You may have to upgrade/downgrade your client program."),
    GAL5026_UNSUPPORTED_RESOURCE_TYPE                 (5026, "E: Error occured. The field 'kind' in the request body is invalid. The value ''{0}'' is not supported. This could indicate a mis-match between client and server levels. Please check with your Ecosystem administrator the level. You may have to upgrade/downgrade your client program."),
    GAL5027_UNSUPPORTED_API_VERSION                   (5027, "E: Error occured. The field 'apiVersion' in the request body is invalid. The value ''{0}'' is not a supported version. Currently the ecosystem accepts the ''{1}'' api version. This could indicate a mis-match between client and server levels. Please check with your Ecosystem administrator the level. You may have to upgrade/downgrade your client program.")
    ;


    private String template ;
    private int templateNumber;

    private ServletErrorMessage(int templateNumber , String template) {
        this.template = "GAL"+Integer.toString(templateNumber)+template ;
        this.templateNumber = templateNumber ;
    }

    public String toString() {
        return this.template ;
    }

    public int getTemplateNumber() {
        return this.templateNumber;
    }

}