package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_AlertsLimit0 implements _callable{

public static PrintWriter pw; 
public static _cls_AlertsLimit0 root;

public static LinkedHashMap<_cls_AlertsLimit0,_cls_AlertsLimit0> _cls_AlertsLimit0_instances = new LinkedHashMap<_cls_AlertsLimit0,_cls_AlertsLimit0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\miche\\Desktop\\school\\year 3\\software testing\\Tutorial\\AlertsLimit/src/output_AlertsLimit.txt");

root = new _cls_AlertsLimit0();
_cls_AlertsLimit0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_AlertsLimit0 parent; //to remain null - this class does not have a parent!
public static boolean v;
public static boolean value;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_AlertsLimit0() {
}

public void initialisation() {
}

public static _cls_AlertsLimit0 _get_cls_AlertsLimit0_inst() { synchronized(_cls_AlertsLimit0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_AlertsLimit0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_AlertsLimit0_instances){
_performLogic_ALertLimit(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_AlertsLimit0[] a = new _cls_AlertsLimit0[1];
synchronized(_cls_AlertsLimit0_instances){
a = _cls_AlertsLimit0_instances.keySet().toArray(a);}
for (_cls_AlertsLimit0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_AlertsLimit0_instances){
_cls_AlertsLimit0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_ALertLimit = 29;

public void _performLogic_ALertLimit(String _info, int... _event) {

_cls_AlertsLimit0.pw.println("[ALertLimit]AUTOMATON::> ALertLimit("+") STATE::>"+ _string_ALertLimit(_state_id_ALertLimit, 0));
_cls_AlertsLimit0.pw.flush();

if (0==1){}
else if (_state_id_ALertLimit==29){
		if (1==0){}
		else if ((_occurredEvent(_event,44/*create_alert*/)) && (value ==false )){
		;
_cls_AlertsLimit0.pw .println ("Alert uploaded");

		_state_id_ALertLimit = 29;//moving to state start
		_goto_ALertLimit(_info);
		}
		else if ((_occurredEvent(_event,44/*create_alert*/)) && (value ==true )){
		;
_cls_AlertsLimit0.pw .println ("Too many alerts");

		_state_id_ALertLimit = 28;//moving to state too_many
		_goto_ALertLimit(_info);
		}
		else if ((_occurredEvent(_event,46/*delete_alerts*/)) && (v ==true )){
		;
_cls_AlertsLimit0.pw .println ("Delete Alerts");

		_state_id_ALertLimit = 29;//moving to state start
		_goto_ALertLimit(_info);
		}
		else if ((_occurredEvent(_event,46/*delete_alerts*/)) && (v ==false )){
		;
_cls_AlertsLimit0.pw .println ("Bad delete");

		_state_id_ALertLimit = 27;//moving to state bad_delete
		_goto_ALertLimit(_info);
		}
}
else if (_state_id_ALertLimit==28){
		if (1==0){}
		else if ((_occurredEvent(_event,46/*delete_alerts*/)) && (v ==false )){
		;
_cls_AlertsLimit0.pw .println ("Bad delete");

		_state_id_ALertLimit = 27;//moving to state bad_delete
		_goto_ALertLimit(_info);
		}
		else if ((_occurredEvent(_event,46/*delete_alerts*/)) && (v ==true )){
		;
_cls_AlertsLimit0.pw .println ("Delete Alerts");

		_state_id_ALertLimit = 29;//moving to state start
		_goto_ALertLimit(_info);
		}
}
}

public void _goto_ALertLimit(String _info){
_cls_AlertsLimit0.pw.println("[ALertLimit]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_ALertLimit(_state_id_ALertLimit, 1));
_cls_AlertsLimit0.pw.flush();
}

public String _string_ALertLimit(int _state_id, int _mode){
switch(_state_id){
case 27: if (_mode == 0) return "bad_delete"; else return "!!!SYSTEM REACHED BAD STATE!!! bad_delete "+new _BadStateExceptionAlertsLimit().toString()+" ";
case 29: if (_mode == 0) return "start"; else return "start";
case 28: if (_mode == 0) return "too_many"; else return "!!!SYSTEM REACHED BAD STATE!!! too_many "+new _BadStateExceptionAlertsLimit().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}