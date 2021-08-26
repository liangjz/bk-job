USE job_execute;

SET NAMES utf8mb4;

DROP PROCEDURE IF EXISTS job_schema_update;

DELIMITER <JOB_UBF>

CREATE PROCEDURE job_schema_update()
BEGIN

    DECLARE db VARCHAR(100);
    SET AUTOCOMMIT = 0;
    SELECT DATABASE() INTO db;
        
    IF NOT EXISTS(SELECT 1
                  FROM information_schema.columns
                  WHERE TABLE_SCHEMA = db
                    AND TABLE_NAME = 'step_instance_script'
                    AND COLUMN_NAME = 'script_source') THEN
        ALTER TABLE step_instance_script ADD COLUMN script_source TINYINT(4) DEFAULT 1;
    END IF;
	
    COMMIT;
END <JOB_UBF>
DELIMITER ;
COMMIT;
CALL job_schema_update();

DROP PROCEDURE IF EXISTS job_schema_update;