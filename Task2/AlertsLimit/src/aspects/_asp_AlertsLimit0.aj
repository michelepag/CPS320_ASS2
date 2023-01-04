package aspects;

import larva.*;
public aspect _asp_AlertsLimit0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_AlertsLimit0.initialize();
}
}
before ( boolean v) : (call(* *.delete_status(..)) && args(v) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_AlertsLimit0.lock){

_cls_AlertsLimit0 _cls_inst = _cls_AlertsLimit0._get_cls_AlertsLimit0_inst();
_cls_inst.v = v;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 46/*delete_alerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 46/*delete_alerts*/);
}
}
before ( boolean value) : (call(* *.create_alert(..)) && args(value) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_AlertsLimit0.lock){

_cls_AlertsLimit0 _cls_inst = _cls_AlertsLimit0._get_cls_AlertsLimit0_inst();
_cls_inst.value = value;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 44/*create_alert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 44/*create_alert*/);
}
}
}